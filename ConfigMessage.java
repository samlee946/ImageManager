package kechengsheji;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

//配置信息类
public class ConfigMessage implements Serializable {
	//上一次打开的文件路径
	public String path;
	public ConfigMessage(){
		path="";
	}
	public ConfigMessage update(String attribute,String value){
		switch(attribute)
		{
		case "path":path=value;return this;
		default: return null;
		}
	}
	public String getData(String attribute){
		switch(attribute)
		{
		case "path":return path;
		default: return null;
		}
		
	}
	public String toString(){
		return "path="+path;
	}
}
