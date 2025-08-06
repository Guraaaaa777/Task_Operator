package TaskOperator;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static ArrayList<task> task = new ArrayList<task>();
	public static int id = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean end = false;
		while(!end) {
			System.out.println("Select Mode\n"+
			           "1:Create Task\n"+
			           "2:List Task\n"+
			           "3:Complete Task\n"+
			           "4:Remove Task\n"
					  );
			switch(scanner.nextInt()) {
				case 1:
					inputTask();
					break;
				case 2:
					liskTask();
					break;
				case 3:
					completeTask();
					break;
				default:
					removeTask();
			}
		}
		
	}
	
	//static関数リスト
	private static void inputTask() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input task name: ");
		String name = scanner.next();
		
		ArrayList<String> tag = new ArrayList<String>();
		
		boolean end = false;
		while(!end) {
			System.out.print("Input TagName(end: \"quit\"): ");
			String tmp = scanner.next();
			if(tmp.equals("quit")) {
				end = true;
			}else {
				tag.add(tmp);
			}
		}
		
		System.out.print("input task info: ");
		String info = scanner.next();
		
		createTask(name,tag,info);
	}
	private static void createTask(String name,ArrayList<String> tag,String info) {
		task.add(new task());
		id +=1;
		task.get(id).setId(id);
		task.get(id).setName(name);
		for(String tmp:tag) {
			task.get(id).addTag(tmp);
		}
		task.get(id).setInfo(info);
		
	}
	private static void liskTask() {
		for(task tmp:task) {
			String tagLine = "";
			for(String tagTmp:tmp.getTag()) {
				tagLine += "/";
				tagLine += tagTmp;
			}
			System.out.println("ID:      "+tmp.getId()+"\n"+
							   "Complete:"+tmp.getComplete()+"\n"+
							   "Name:    "+tmp.getName()+"\n"+
							   "Tag:     "+tagLine+"\n"+
							   "Info:    "+tmp.getInfo()+"\n"
								);
		}
	}
	private static void completeTask() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input task id: ");
		int id = scanner.nextInt();
		try {
			task.get(id).completeTask();
		}catch(Exception e) {
			System.out.println("no match");
		}
	}
	private static void removeTask() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input task id: ");
		int id = scanner.nextInt();
		try {
			task.remove(id);
		}catch(Exception e) {
			System.out.println("no match");
		}
	}
}

//タスク(仮)
class task{
	private int id;
	private boolean complete;
	private String name;
	ArrayList<String> tag = new ArrayList<String>();
	private String info;
	task() {
		complete = false;
	}
	
	public int getId() {
		return id;
	}
	public boolean getComplete() {
		return complete;
	}
	public String getName() {
		return name;
	}
	public ArrayList<String> getTag(){
		return tag;
	}
	public String getInfo() {
		return info;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addTag(String tagName) {
		this.tag.add(tagName);
	}
	public void removeTag(String tagName) {
		
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void completeTask() {
		complete = true;
	}
}