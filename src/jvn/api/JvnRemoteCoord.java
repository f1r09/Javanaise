/*
 * JAVANAISE API
 * JvnRemoteCoord interface
 * This interface defines the remote interface provided by the Javanaise coordinator.
 */

package jvn.api;

import jvn.JvnException;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote Interface of the JVN Coordinator.
 */
public interface JvnRemoteCoord extends Remote {
	/**
	 * Allocate a NEW JVN object id (usually allocated to a newly created JVN object)
	 *
	 * @return the JVN object identification
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	int jvnGetObjectId() throws RemoteException, JvnException;

	/**
	 * Associate a symbolic name with a JVN object
	 *
	 * @param jon the JVN object name
	 * @param jo  the JVN object
	 * @param js  the remote reference of the JVNServer
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	void jvnRegisterObject(String jon, JvnObject jo, JvnRemoteServer js) throws RemoteException, JvnException;

	/**
	 * Get the reference of a JVN object managed by a given JVN server
	 *
	 * @param jon the JVN object name
	 * @param js  the remote reference of the JVN server
	 * @return the JVN object
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	JvnObject jvnLookupObject(String jon, JvnRemoteServer js) throws RemoteException, JvnException;

	/**
	 * Get a Read lock on a JVN object managed by a given JVN server
	 *
	 * @param joi the JVN object identification
	 * @param js  the remote reference of the server
	 * @return the current JVN object state
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	Serializable jvnLockRead(int joi, JvnRemoteServer js) throws RemoteException, JvnException;

	/**
	 * Get a Write lock on a JVN object managed by a given JVN server
	 *
	 * @param joi the JVN object identification
	 * @param js  the remote reference of the server
	 * @return the current JVN object state
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	Serializable jvnLockWrite(int joi, JvnRemoteServer js) throws RemoteException, JvnException;

	/**
	 * A JVN server terminates
	 *
	 * @param js the remote reference of the server
	 * @throws RemoteException Java RMI exception
	 * @throws JvnException    JVN exception
	 **/
	void jvnTerminate(JvnRemoteServer js) throws RemoteException, JvnException;
}
