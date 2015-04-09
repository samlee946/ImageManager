
public class ConfigMessage {
	public String path;
	public boolean update(String attribute,String value){
		switch(attribute)
		{
		case "path":path=value;return true;
		default: return false;
		}
	}
	public String getData(String attribute){
		switch(attribute)
		{
		case "path":return path;
		default: return null;
		}
		
	}
}
