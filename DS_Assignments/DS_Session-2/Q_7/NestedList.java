package Q_7;

import java.util.List;

public class NestedList {
	
	List<Object> nestedList = null;
	
	public NestedList (List<Object> nestedList) {
		this.nestedList = nestedList;
	}
	
	public String getValue(String positionSpecifier) {
		positionSpecifier = positionSpecifier.toUpperCase();
		Object listElement = null;
		
		try {
			if(isValid(positionSpecifier)) {
				int specifierLength = positionSpecifier.length();
				for(int i=0 ; i<specifierLength ; i++) {
					char character = positionSpecifier.charAt(i);
					switch(character) {
						case 'T':
							listElement = nestedList.get(nestedList.size()-1);
							break;
						
						case 'H':
							listElement =nestedList.get(0);
							break;
						
						default:
							break;
					}
					if(!(listElement instanceof Integer))
						nestedList = (List)listElement;
				}
				if(listElement instanceof Integer) {
					return "Integer element Obtained !";
				} else {
					return "Error occured !";
				}
			} else {
				return "Invalid Specifier entered !";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception  occurred !";
		}
		
	}

	private boolean isValid(String positionSpecifier) {
		int length = positionSpecifier.length();
		for(int i=0 ; i<length ; i++) {
			if(!(positionSpecifier.charAt(i)=='T' || positionSpecifier.charAt(i)=='H')) {
				return false;
			}
		}
		return true;
	}
	
}
