package VirtualCommandPrompt;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * class containing attribute of a directory
 * created on August 07, 2018
 */
public class Directory {
	private String directoryName;
	private Date creationTime;
	private List<Directory> subFoldersList = new LinkedList<Directory>();
	Directory parentDirectory;
	String directoryPath="";
	
	public Directory (String directoryName, Date creationTime, Directory parentDirectory, String directoryPath) {
		this.directoryName = directoryName;
		this.creationTime = creationTime;
		this.parentDirectory = parentDirectory;
		this.directoryPath = directoryPath;
	}
	
	/**
	 * method to get name of directory
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * method to get creation time of the directory
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * method to obtain list of subfolders
	 */
	public List<Directory> getSubFolders() {
		return subFoldersList;
	}

	/**
	 * method to get parent node of the directory
	 */
	public Directory getParentDirectory() {
		return parentDirectory;
	}
	
	/**
	 * method to add a subfolder in list of subfolders of the current directory
	 */
	public void addSubfolder(Directory subfolder) {
		subFoldersList.add(subfolder);
	}

	/**
	 * @return directory path
	 */
	public String getDirectoryPath() {
		return directoryPath;
	}
	
}


