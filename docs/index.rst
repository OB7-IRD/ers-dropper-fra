.. ERS Dropper for French documentation master file, created by
   sphinx-quickstart on Fri Nov  8 17:21:18 2019.

ERS Dropper for French's documentation!
===========================================


.. meta::
   :keywords: ERS injector french purse-seiners tuna 
   :description lang=en: Injector of data from the fishing logbook of french purse seiners.
   

Introduction
============

Context
-------



Objectives
----------

This project is to develop software to transfer data from the CERIT into the AVDTH database used by the IRD, in order to analyze logbook data with existing tools (T3, R script ...). The **ERS Dropper** project consist to extract, transform and load the logbook data from XML message in a business-oriented database.

Data workflow
-------------

The schema below shows  the data workflow of logbook data from the ship to the IRD with. 

.. image:: _static/dataflow_logbook_fra.png

This documentation present only the part on the data injector in the database. The *JPE web application* project is shared with the *ERS Dropper for French* project and is available on github with his documentation: https://github.com/OB7-IRD/jpe.

Documentation
==============

.. toctree::
   :maxdepth: 1

   whatsnew
   installation
   development

.. Licensed under GNU General Public License v3.0
   https://www.gnu.org/licenses/gpl-3.0.en.html


Indices and tables
==================

* :ref:`genindex`
* :ref:`search`


