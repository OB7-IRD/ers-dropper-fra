How to Install **ERS Dropper** 
===============================

Prerequisites
-------------

ERS Dropper requires to install `Python 3 <http://www.python.org/>`_, Java_ and the PostgreSQL_'s relational database management system. Moreover the user you are logging in as must have sudo privileges.

Installation
------------

Create ERS system user
~~~~~~~~~~~~~~~~~~~~~~

Running ERS Dropper as the root user is a security risk and not considered best practice. We will create a new system user and group with home directory :code:'/opt/ers-dropper' that will run the ERS Dropper service:

.. code-block:: console
    
    $ sudo useradd -m -U -d /opt/ers-dropper -s /bin/false ers

Download ERS Dropper
~~~~~~~~~~~~~~~~~~~~

In purpose to faciltate the deployement, there is ready-to-install repository which is available at https://github.com/OB7-IRD/ers-fra-processing-module. So you must download the latest archive on you server and unarchive it with the command line below:


.. code-block:: console

    $ cd /tmp
    $ wget https://github.com/OB7-IRD/ers-fra-processing-module/archive/v1.0.0.tar.gz
    $ tar -xzvf v1.0.0.tar.gz 

Move the source files to it to the '''/opt/ers-dropper''' directory:

.. code-block:: console

    $ sudo mv v1.0.0 /opt/ers-dropper

The ers user that we previously set up needs to have access to the ers-dropper installation directory.

Run the following command to change the directory ownership to user and group ers:

.. code-block:: console

    $ sudo chown -R ers: /opt/ers-dropper


Make the scripts inside the bin directory executable by issuing the following chmod command: :

.. code-block:: console

    $ sudo sh -c 'chmod +x /opt/ers-dropper/apps/bin/*'

Both scripts requires somes Python packages, you install it whith :

.. code-block:: console

    $ pip3 install pysftp

Configuration
-------------
Now the application is installed, you will need to create the database and configure the application.


Create the database
~~~~~~~~~~~~~~~~~~~
First step, we create an user for the database and assign a password immediately: 

.. code-block:: console

    $ createuser -P -s -e dbaers
    Enter password for new role: <your-password>
    Enter it again: <your-password>
    CREATE ROLE dbaers PASSWORD 'md5b5f5ba1a423792b526f799ae4eb3d59e' SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN;

Second step, we create the database :

.. code-block:: console
    
    createdb -O dbaers eva_prod

You can also create the database with the SQL instruction below:

.. code-block:: sql

    CREATE DATABASE eva_prod OWNER dbaers;

You need to execute the SQL script which contains the instructions to create the table:

.. code-block:: console

    psql -U dbaers -d eva_prod -a -f /opt/ers-dropper/scripts/create_db_ers.sql

Configure the software
~~~~~~~~~~~~~~~~~~~~~~

To configure the application, we need to log with the *ers* user:

.. code-block:: console

    $ su - ers

We need to and an environment variable, which are used by the application's scripts, in the user profile .

.. code-block:: console

    $ nano ~/.bash_profile
    export ERS_HOME=/opt/ers-dropper/apps
    export ERS_DATA_HOME=/home/ers/ers_data_fra

Now we create the configuration directory and copy the default configuration file.

.. code-block:: console

    $ mkdir -p /home/ers/.config/ers-dropper-fra
    $ cp -fr $ERS_HOME/conf/ers-dropper-fra-config.xml /home/ers/.config/ers-dropper-fra/

The configuration file contains the properties below. You have just write the user password of the database.

.. code-block:: xml

    <?xml version="1.0" encoding="UTF-8" standalone="no"?>
    <!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
    <properties>
        <comment>ERS Dropper FRA Service configuration's properties</comment>
        <entry key="repertoire_depot">/home/ers/ers_data_fra/depot</entry>
        <entry key="repertoire_traites">/home/ers/ers_data_fra/traites</entry>
        <entry key="repertoire_erreur">/home/ers/ers_data_fra/erreur</entry>
        <entry key="repertoire_envoi">/home/ers/ers_data_fra/envoi</entry>
   
        <entry key="formatage_xml_ers">/v3/ers-3.xsd</entry>
        <entry key="formatageEuropeen_xml">/v3Europeen/ersComplet3.xsd</entry>
        <entry key="formatage_xml_valeurs">/v3/ers-codes-3.xsd</entry>
        <entry key="formatage_xml">/v3/ersComplet3.xsd</entry>
        <entry key="formatage_xml_ops">/v3/ers-operations-3.xsd</entry>


        <entry key="jdbc_driver">org.postgresql.Driver</entry>
        <entry key="jdbc_url">jdbc:postgresql://localhost:5432/eva_prod</entry>
        <entry key="jdbc_username">dbaers</entry>
        <entry key="jdbc_password">your-password</entry>
    </properties>

You can edit the configuration file the command :

.. code-block:: console

    $ nano /home/ers/.config/ers-dropper-fra/ers-dropper-fra-config.xml

You need also to create the repositories which will contains your ERS message from the **CERIT**. It's corredponding to first four parameters of the configuration file. The commands belows create the repositories:

.. code-block:: console

        $ mkdir -p $ERS_DATA_HOME/depot
        $ mkdir -p $ERS_DATA_HOME/traites
        $ mkdir -p $ERS_DATA_HOME/erreur
        $ mkdir -p $ERS_DATA_HOME/envoi
        $ mkdir -p $ERS_DATA_HOME/archives

Note: The archives directory is needed by one script in purpose to 

To check that the repositories are created:

.. code-block:: console

        $ ls -l  $ERS_DATA_HOME
        total 5
        drwxrwxr-x 2 ers ers 1024 15 nov.  11:45 archives
        drwxrwxr-x 2 ers ers 1024 14 nov.  13:09 depot
        drwxrwxr-x 2 ers ers 1024 14 nov.  13:09 envoi
        drwxrwxr-x 2 ers ers 1024 14 nov.  13:09 erreur
        drwxrwxr-x 2 ers ers 1024 14 nov.  13:09 traites


Running the application
=======================

Once the application is installed and configured, you have two options to run the ERS Dropper.
But previously, you need get the ERS messages from CERIT server:

.. code-block:: console
    
    $ /opt/ers-dropper/apps/bin/get_message.py

After you can run manually the injector via a specified script with the command below :

.. code-block:: console

    $ sh /opt/ers-dropper/apps/bin/dropper.sh > /opt/ers-dropper/apps/log/ers.log


Or you can configure the script as service. The configuration depends of your operating system. 
For Linux OS, you will need to add the script at crontab. You can edit the crontab with `crontab -e` and you add the instructions belows:

.. code-block:: bash

    ##### ERS software
    # Dropper run every day at 0730
    30 7 * * * export ERS_HOME=/opt/ers-dropper/apps/;bash /opt/ers-dropper/apps/bin/dropper.sh > $ERS_HOME/logs/ers.log
    # Copy the ERS messages, every day at 7:00
    0 7 * * * /opt/ers-dropper/apps/bin/get_message.py >> /opt/ers-dropper/apps/logs/sftp_ers_cerit.log


.. _Tomcat: https://tomcat.apache.org/
.. _Java: https://www.oracle.com/technetwork/java/javase/downloads/index.html
.. _PostgreSQL: https://www.postgresql.org/