package New_Package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment11 {

	
	public static void main(String[] args) {
		
		
		
		ArrayList<String> a=new ArrayList<String>();
		a.add("2Name14");
		a.add("Name2");
		a.add("2Name3");
		a.add("Name44");
		
		
		List<String> a1=Arrays.asList("game1","game4","game3","game4");
	
		long l1=a.stream().count();
		System.out.println(l1);
		long l2=a.stream().filter(s->s.startsWith("2")).count();
		System.out.println(l2);
		a.stream().filter(s->s.endsWith("4")).sorted().forEach(s->System.out.println(s));
		
		a.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		a.stream().filter(s->s.length()>4).limit(3).forEach(s->System.out.println(s+"ashwani"));
		
	System.out.println(Stream.of("game1","game4","game3","game4").filter(s->s.endsWith("4")).count()+"count");
	
	Stream.of("game1","game4","game3","game4").map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	Stream.concat(a.stream(), a1.stream()).map(s->s.toLowerCase()).forEach(s->System.out.println(s+"yes"));
	
System.out.println(Stream.concat(a.stream(), a1.stream()).anyMatch(s->s.equalsIgnoreCase("game11")));

List<Integer> l=Arrays.asList(3,4,8,2,1,6,9,9,4);

l.stream().distinct().sorted().forEach(s->System.out.println(s));
List<Integer> l11=l.stream().distinct().sorted().collect(Collectors.toList());
System.out.println(l11.get(0));

l.stream().distinct().sorted().limit(3).forEach(s->System.out.println(s));
System.out.println("git1");
		
	}
	
	
}
