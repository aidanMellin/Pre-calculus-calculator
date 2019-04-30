package out.newOutput.data;

public class solveTrianglesData {
	public static void main(String[] args) {
		//Nothing needed here

	}
	
	public static String SSS(double s1, double s2, double s3) {
		String list = new String();
		
		//Find two of the unknown angles with law of cosines
		double a1 = Math.acos((Math.pow(s2,2)+Math.pow(s3,2)-Math.pow(s1,2))/(2*s2*s3))*180/Math.PI;
		double a2 = Math.acos((Math.pow(s1,2)+Math.pow(s3,2)-Math.pow(s2,2))/(2*s1*s3))*180/Math.PI;
		
		//Find third angle by subtracting from the two found 180
		double a3 = 180-a1-a2;
		
		//Round the outputs to make it "pretty"
		a1 = Math.round(a1*1000.0)/1000.0;
		a2 = Math.round(a2*1000.0)/1000.0;
		a3 = Math.round(a3*1000.0)/1000.0;
		
		//Add the solutions to the list
		list = (s1+","+a1+","+s2+","+a2+","+s3+","+a3);	
		System.out.println(list);
		
		
		//return the list to be printed by triangleSolver
		return list;		
	}
	
	public static String SAS(double s2, double a1, double s3){

		System.out.println("S2 "+s2+" A1 "+a1+" S3 "+s3);
		String list = new String();
		a1 = a1 * Math.PI / 180;
		System.out.println(a1);

		double s1 = Math.sqrt(Math.pow(s2, 2) + Math.pow(s3, 2) - ((2 * s2 * s3) * Math.cos(a1)));
		s1 = Math.round(s1*1000.0)/1000.0;
		System.out.println("s1 "+s1);
				
		double a2 = Math.asin(Math.sin(a1)*s2/s1);
		a1 = Math.round(a1 * 180/Math.PI*1000.0)/1000.0;
		a2 = Math.round(a2 * 180/Math.PI*1000.0)/1000.0;
		double a3 = 180-(a1+a2);
		
		//Add solutions to the list for output
		list = (s1+","+a1+","+s2+","+a2+","+s3+","+a3);	
			
		//return list to be printed by triangleSolver
		return list;
		
	}
	
	public static String SSA(double s1, double s2, double a1 ) {
		int possibleSol = AmbigCase(s1,s2,a1);
		String list = new String();
			
		//Convert to radians
		a1 = a1*Math.PI/180;
		double a2 = Math.asin(((s2*Math.sin(a1))/s1));
		double a3 = 180-((a1*180/Math.PI)+(a2*180/Math.PI));		
		a3 = a3* Math.PI/180;
		
		//Round off the numbers to make them pretty
		double s3 = Math.round((Math.sin(a3)*s1)/Math.sin(a1)*1000.0)/1000.0;
		a1 = (a1*180/Math.PI);
		a2 = Math.round(a2*180/Math.PI*1000.0)/1000.0;
		a3 = Math.round(a3*180/Math.PI*1000.0)/1000.0;
		
		//Blank strings for the Ambig Case
		String a2S = "";
		double a3New  = 0;
		String s3S = "";
		String a3S = "";
		
		

		//Takes the output of the Ambig Case and spits it back so it doesnt have to be in the other class (triangleSolver) as an if statement
		if (possibleSol == 2) {
			a2S = a2+" "+ (180-a2);
			a3New = 180-(a1+(180-a2));
			//System.out.println("A3 Stuff \n"+a3New);
			//System.out.println((Math.sin(a3New)*21)+"\n");
			a3S = a3+" "+Math.round(a3New*1000.0)/1000.0;
			double s3New = Math.round(Math.sin(a3New*Math.PI/180)*s1/Math.sin(a1*Math.PI/180)*1000.0)/1000.0;
			s3S = s3+" "+s3New;	
			System.out.println("s3s "+s3S);
			//System.out.println(a3+" A3 + S3 "+s3S);
		} else if (possibleSol == 1) {
			a2S = Double.toString(a2);
		} else {
			a2S = "This ain't it chief";
		}
		
		
		list = (s1+","+a1+","+(Math.round(s2*1000.0)/1000.0)+","+a2S+","+s3S+","+a3S);	
		System.out.println(list);
		
		return list;
		
	}
	
	public static String ASA(double a1, double s3, double a2){
		
		String list = new String();
	
		//3rd angle can be found by subtracting 1 & 2 from 180
		double a3 = 180-(a1+a2);
		
		//Convert the angles to radians
		a1 = a1 * Math.PI/180;
		a2 = a2 * Math.PI/180;
		a3 = a3 * Math.PI/180;
		
		//Find the two sides through Law of Sines
		double s1 = Math.round(s3*(Math.sin(a1)/Math.sin(a3))*1000.0)/1000.0;
		double s2 = Math.round(s3*(Math.sin(a2)/Math.sin(a3))*1000.0)/1000.0;
		
		//Convert back to degrees for output
		a1 = a1 * 180/Math.PI;
		a2 = a2 * 180/Math.PI;
		a3 = a3 * 180/Math.PI;
		
		list = (s1+","+a1+","+s2+","+a2+","+s3+","+a3);
		
		return list;
	}
	
	public static String AAS(double a1, double a2, double s1){
		String list = new String();
		
		double a3 = 180 - (a1+a2);
		System.out.println(a3+" A3");
		
		//Convert angles to radians
		a1 = a1*Math.PI/180;
		a2 = a2*Math.PI/180;
		a3 = a3*Math.PI/180;
		
		System.out.println("Radians \n"+a1);
		System.out.println(a2);
		System.out.println(a3);
		
		double s2 = (s1/Math.sin(a1))*Math.sin(a2);
		double s3 = s1/Math.sin(a1)*Math.sin(a3);
		
		a1 = a1 * 180/Math.PI;
		a2 = a2 * 180/Math.PI;
		a3 = a3 * 180/Math.PI;
		System.out.println("Degrees \n"+a1);
		System.out.println(a2);
		System.out.println(a3);
		
		list = (s1+","+a1+","+s2+","+a2+","+s3+","+a3);		
		
		return list;
	}
	
	//Checks whether or not the triangle is actually possible
	public static boolean TriPossible(double s1, double s2, double s3) {
		System.out.println(s1+" "+s2+" "+s3);
		boolean possible = true;
		if (s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1) {
			possible = true;
		} else {
			possible = false;
		}
		return possible;
	}
	
	//Solves for whether or not the triangle has two solutions, and if it does, solves for the other values
	public static int AmbigCase(double s1, double s2, double a1) {
		int isPossible = 3;
		
		if (s1 == s2*Math.sin(a1)) {
			isPossible = 1;
			System.out.println("1Tri");
		} else if (s1 > s2*Math.sin(a1)) {
			isPossible = 2;
			System.out.println("2Tri");
		} else {
			isPossible = 0;
			System.out.println("0Tri");
		}
		return isPossible;
	}


}
