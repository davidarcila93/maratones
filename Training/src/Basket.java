import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class Basket {
	public static void main(String[] args)throws Exception {
		
		String cadena="222333455";
		String operadores= "*/+-";
		String str="";
		String strmin="";
		double ans;
		double minans=100000000.0;
		double objetivo=750.0;
		double min=1000000.0;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int size=cadena.length()-1;
		String aux="";
		for (int i = 0; i < size; i++) {
			aux+=0;
		}
		while(aux!=null){
			str="";
			for (int i = 0; i < cadena.length(); i++) {
				str+=cadena.charAt(i);
				if(i<cadena.length()-1 && aux.charAt(i)!='4'){
					str+=operadores.charAt(aux.charAt(i)-'0');
				}
			}	
			
			
			ans=(double)engine.eval(str);
			
			if(Math.abs(ans-objetivo)<min){
				min=Math.abs(ans-objetivo);
				minans=ans;
				strmin=str;
						
			}
			aux=nextstring(aux);
		}	
		System.out.println(strmin);
		System.out.println(min);
		System.out.println(minans);
	}
	private static String nextstring(String aux) {
		int size=aux.length();
		String ans="";
		for (int i = 0; i < size; i++) {
			if(aux.charAt(i)=='4'){
				ans+=0;
				if(i==size-1)
					return null;
			}
			else{
				ans+=Integer.parseInt(""+aux.charAt(i))+1;
				break;
			}
		}
		while(aux.length()>ans.length()){
			ans+=aux.charAt(ans.length());
		}
		return ans;
	}

}
