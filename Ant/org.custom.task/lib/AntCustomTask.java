package org.custom.ant.task

import org.apache.tools.ant.Task; // apacheAntをimport

public class AntCustomTask extends Task{	// Taskクラスを継承

	private String name;

	public class execute() throws BuildException{
		//処理
	}

	public String setName(String name){
		this.name = name;
	}

} // エクスポートでjar化