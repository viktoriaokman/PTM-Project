package com.company;

import java.util.Arrays;
import java.util.List;

// edit these imports according to your project

public class TestSetter {
	
	public static void setClasses(DesignTest dt){
		
		// set the server's Interface, e.g., "Server.class"
		// don't forget to import the correct package e.g., "import server.Server"
		dt.setServerInteface(IServer.class);
		// now fill in the other types according to their names
		// server's implementation
		dt.setServerClass(SocketServer.class);
		// client handler interface
		dt.setClientHandlerInterface(IClientHandler.class);
		// client handler class
		dt.setClientHandlerClass(ClientHandler.class);
		// cache manager interface
		dt.setCacheManagerInterface(ICacheManager.class);
		// cache manager class
		dt.setCacheManagerClass(FileCacheManager.class);
		// solver interface
		dt.setSolverInterface(ISolver.class);
		// solver class
		dt.setSolverClass(PipeGameSolver.class);
		// searchable interface
		dt.setSearchableInterface(ISearchable.class);
		// searcher interface
		dt.setSearcherInterface(ISearcher.class);
		// your searchable pipe game class
		dt.setPipeGameClass(PipeGameBoard.class);
		// your Best First Search implementation
		dt.setBestFSClass(GBFS.class);
	}
	
	// run your server here
	static SocketServer s;
	public static void runServer(int port){
		s=new SocketServer(port);
		s.start(new ClientHandler());
	}
	// stop your server here
	public static void stopServer(){
		s.stop();
	}
	
	/* ------------- Best First Search Test --------------
	 * You are given a Word Game
	 * Create a new Searchable from the Word Game
	 * Solve the Word Game
	 * and return a list of index switches as strings
	 * e.g., {"0,5" , "3,4" , "2,1"}
	 *  
	 */
	
	public static List<String> solveWordGame(WordGame tp) {
		// of course, you should replace this code with a calculated answer...
		List<String> sol=Arrays.asList("0,3","1,3");
		return sol;
	}

}
