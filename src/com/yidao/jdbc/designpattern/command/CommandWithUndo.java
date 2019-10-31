package com.yidao.jdbc.designpattern.command;
//命令接口
public interface CommandWithUndo extends Command{
	void undo();
}
