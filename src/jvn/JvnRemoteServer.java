/***
 * JAVANAISE API
 * JvnRemoteServer interface
 * Defines the remote interface provided by a JVN server 
 * This interface is intended to be invoked by the Javanaise coordinator 
 * Contact: 
 * <p>
 * Authors: 
 */

package jvn;

import java.rmi.*;
import java.io.*;

/**
 * Remote interface of a JVN server (used by a remote JvnCoord)
 */
public interface JvnRemoteServer extends Remote {

    /**
     * Invalidate the Read lock of a JVN object
     *
     * @param joi : the JVN object id
     * @throws RemoteException,JvnException Jvn exception
     **/
    public void jvnInvalidateReader(int joi) throws RemoteException, JvnException;

    /**
     * Invalidate the Write lock of a JVN object
     *
     * @param joi : the JVN object id
     * @return the current JVN object state
     * @throws RemoteException,JvnException Jvn exception
     **/
    public Serializable jvnInvalidateWriter(int joi) throws RemoteException, JvnException;

    /**
     * Reduce the Write lock of a JVN object
     *
     * @param joi : the JVN object id
     * @return the current JVN object state
     * @throws RemoteException,JvnException Jvn exception
     **/
    public Serializable jvnInvalidateWriterForReader(int joi) throws RemoteException, JvnException;
}
