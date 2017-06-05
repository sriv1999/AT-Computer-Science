package maps;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish {
	private Map<String, String> pairs;

	public SpanishToEnglish() {
		pairs = new TreeMap<String, String> ();
	}

	public void putEntry(String entry) {
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);
	}

	public String translate(String sent) {
		Scanner chop = new Scanner(sent);
		String result = "";
		while (chop.hasNext()){
			result += pairs.get(chop.next()) + " ";
		}
		chop.close();
		return result;
	}

	public String toString() {
		return pairs.toString().replaceAll("\\,", "\n");
	}
	
	public static void main(String[] args){
		SpanishToEnglish one = new SpanishToEnglish();
		one.putEntry("rearrancar reboot");
		one.putEntry("pantalla screen");
		one.putEntry("texto text");
		one.putEntry("virus virus");
		one.putEntry("tinta ink");
		one.putEntry("mitad half");
		one.putEntry("interno internal");
		one.putEntry("memoria memory");
		one.putEntry("papel paper");
		one.putEntry("energia power");
		one.putEntry("fallo bug");
		one.putEntry("pelo hair");
		one.putEntry("el the");
		one.putEntry("dos two");
		one.putEntry("todas all");
		one.putEntry("en in");
		one.putEntry("de of");
		one.putEntry("los the");
		one.putEntry("comprar buy");
		one.putEntry("tarde afternoon");
		one.putEntry("muchachos boys");
		one.putEntry("tienen have");
		one.putEntry("ordenador computer");
		one.putEntry("con with");
		one.putEntry("antes before");
		one.putEntry("vacio empty");
		one.putEntry("tu you");
		one.putEntry("hambre hunger");
		one.putEntry("contaminado corrupt");
		one.putEntry("a to");
		one.putEntry("una a");
		one.putEntry("la the");
		one.putEntry("cafe brown");
		one.putEntry("su your");
		one.putEntry("es is");
		one.putEntry("quiero want");
		one.putEntry("quieres want");
		one.putEntry("vamos go");
		one.putEntry("mi my");
		one.putEntry("barco ship");
		one.putEntry("nosotros we");
		one.putEntry("casa house");
		one.putEntry("yo i");
		one.putEntry("borrar delete");
		one.putEntry("necesita necessary");
		one.putEntry("despues after");
		
		System.out.println(one);
		System.out.println();
		
		System.out.println(one.translate("yo quiero una ordenador virus "
				+ "todas de los muchachos tienen interno memoria "
				+ "mi pelo es cafe "
				+ "tu quieres tinta con su papel "
				+ "rearrancar el ordenador a vacio el pantalla"));
	}
}