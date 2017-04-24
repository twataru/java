package org.custom.ant.task //疑似パッケージ

import org.apache.tools.ant.Task; // apacheAntをimport

public class AntCustomTask extends Task{	// Taskクラスを継承

	private String name; // タグのオプションになる

	public class execute() throws BuildException{
		//処理
	}

	public String setName(String name){
		this.name = name;
	}

} // エクスポートでjar化