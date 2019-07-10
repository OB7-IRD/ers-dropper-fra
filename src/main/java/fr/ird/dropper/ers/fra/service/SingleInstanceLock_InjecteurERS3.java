package fr.ird.dropper.ers.fra.service;

import java.io.File;
import java.io.IOException;

/**
 * This static class is in charge of file-locking the program so no more than
 * one instance can be run at the same time.
 *
 * @author nirei
 */
public class SingleInstanceLock_InjecteurERS3 {

    private static final String LOCK_FILEPATH = System.getProperty("java.io.tmpdir") + File.separator + "injecteur_FRA_ERS3.lock";
    private static final File lock = new File(LOCK_FILEPATH);
    private static boolean locked = false;

    private SingleInstanceLock_InjecteurERS3() {
    }

    /**
     * Creates the lock file if it's not present and requests its deletion on
     * program termination or informs that the program is already running if
     * that's the case.
     *
     * @return true - if the operation was succesful or if the program already
     * has the lock.<br>
     * false - if the program is already running
     * @throws IOException if the lock file cannot be created.
     */
    public static boolean lock() throws IOException {
        if (locked) {
            return true;
        }

        if (lock.exists()) {
            return false;
        }

        lock.createNewFile();
        lock.deleteOnExit();
        locked = true;
        return true;
    }
}
