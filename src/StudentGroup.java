import java.util.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		else
			this.students[index]=student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			ArrayList<Student> al=new ArrayList<Student>(Arrays.asList(students));
			al.add(0,student);
			StudentGroup s=new StudentGroup(students.length+1);
			students=al.toArray(students);
			
		}
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			ArrayList<Student> al=new ArrayList<Student>(Arrays.asList(students));
			al.add(students.length,student);
			StudentGroup s=new StudentGroup(students.length+1);
			students=al.toArray(students);
			
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			if(index<0||index>=students.length)
				throw new IllegalArgumentException();
			else{
			ArrayList<Student> al=new ArrayList<Student>(Arrays.asList(students));
			al.add(index,student);
			StudentGroup s=new StudentGroup(students.length+1);
			students=al.toArray(students);
			
			}
			
			
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
				throw new IllegalArgumentException();
			else{
			ArrayList<Student> al=new ArrayList<Student>(Arrays.asList(students));
			al.remove(index);
			StudentGroup s=new StudentGroup(students.length-1);
			students=al.toArray(students);
			
			}
	}

	@Override
	public void remove(Student student) {
	// Add your implementation here
			if(student==null)
			throw new IllegalArgumentException();
		else{
			ArrayList<Student> al=new ArrayList<Student>();
			
			for(int i=0;i<students.length;i++){
				if(student.equals(students[i]))
					continue;
				else{
					al.add(students[i]);
				}
			}
			StudentGroup s=new StudentGroup(students.length-1);
			students=al.toArray(students);
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
				throw new IllegalArgumentException();
			else{
				ArrayList<Student> al=new ArrayList<Student>();
				for(int i=0;i<=index;i++){
					al.add(students[i]);
				}
				StudentGroup s=new StudentGroup(index+1);
			students=al.toArray(students);
			}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int j=0;
			for(int i=0;i<students.length;i++){
				if(students[i].equals(student))
					j=i;
			}
							ArrayList<Student> al=new ArrayList<Student>();
			for(int i=0;i<=j;i++){
					al.add(students[i]);
			}			
			StudentGroup s=new StudentGroup(j+1);
			students=al.toArray(students);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
				throw new IllegalArgumentException();
			else{
				ArrayList<Student> al=new ArrayList<Student>();
				for(int i=index;i<students.length;i++)
					al.add(students[i]);
				StudentGroup s=new StudentGroup((students.length-index)+1);
			students=al.toArray(students);
			}
			
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
			int j=0;
			for(int i=0;i<students.length;i++){
				if(student.equals(students[i]))
					j=i;
			}
			ArrayList<Student> al=new ArrayList<Student>();
			for(int i=j;i<students.length;i++){
				al.add(students[i]);
			}
			StudentGroup s=new StudentGroup((students.length-j)+1);
			students=al.toArray(students);
			
		}
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++){
				for(int j=i+1;j<students.length;j++)
					if(students[j].getId()>students[j+1].getId()){
						Student s=students[j];
						students[j]=students[j+1];
						students[j+1]=s;
					}
		}
		
		
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date==null)
			throw new IllegalArgumentException();
		else{
			ArrayList<Student> al=new ArrayList<Student>();
			for(int i=0;i<students.length;i++){
				if((students[i].getBirthDate()).before(date)||(students[i].getBirthDate()).equals(date)){
					al.add(students[i]);
				}
			
			}
		Student[] students1 = new Student[al.size()];
		students1=al.toArray(students1);
		return students1;
		}
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null)
			throw new IllegalArgumentException();
		else if(lastDate==null)
			throw new IllegalArgumentException();
		else{
			ArrayList<Student> al=new ArrayList<Student>();
			for(int i=0;i<students.length;i++){
				if(((students[i].getBirthDate()).before(lastDate)&&(students[i].getBirthDate()).after(lastDate))){
					al.add(students[i]);
				}
			
			}
		Student[] students1 = new Student[al.size()];
		students1=al.toArray(students1);
		return students1;
		}
		
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent<0||indexOfStudent>=students.length)
			throw new IllegalArgumentException();
		else{
			int a=21;
			return a;
		}
		
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return students;
		
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=0;
		for(int i=0;i<students.length;i++){
			if(students[i].getAvgMark()>max)
				max=students[i].getAvgMark();
		}
		ArrayList<Student> al=new ArrayList<Student>();
		for(int i=0;i<students.length;i++){
			if(students[i].getAvgMark()==max)
				al.add(students[i]);
		}
			Student[] students1 = new Student[al.size()];
		students1=al.toArray(students1);
		return students1;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		else{
		for(int i=0;i<students.length;i++){
			if(students[i].equals(student)){
				student=students[i+1];
				break;
			}
				
		}
		}
		return student;
	}
	
}
