package javaOOP;

public class Testing {

	public static void main(String[] args) {
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
		
		//Happy case
		topic.setPersonName("Automation FC");
		System.out.println(topic.getPersonName());
		
		//Unhappy case
//		topic.setPersonName(null);
		System.out.println(topic.getPersonName());
		
//		topic.setPersonName("");
		System.out.println(topic.getPersonName());
		
		topic.setPersonPhone(15);
		System.out.println(topic.getPersonPhone());
		
	}

}
