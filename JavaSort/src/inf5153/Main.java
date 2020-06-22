package inf5153;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

class Student {
	private int studentID;
	private String firstName;
	private String lastName;

	public Student(int studentID, String firstName, String lastName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return String.format("%d - %s - %s", studentID, firstName, lastName);
	}
}

// Version orienté-objet pur

class NewSort<T, K> implements Comparator<T> {
    private KeyGetter<T, K> keyGetter;
    private Comparer<K> comparer;
    private CompareStrategy compareStrategy;

    NewSort(KeyGetter<T, K> keyGetter, Comparer<K> comparer, CompareStrategy compareStrategy) {
        this.keyGetter = keyGetter;
        this.comparer = comparer;
        this.compareStrategy = compareStrategy;
    }

    @Override
    public int compare(T o1, T o2) {
        return compareStrategy.apply(comparer.compare(keyGetter.getKey(o1), keyGetter.getKey(o2)));
    }
}

interface CompareStrategy {
    int apply(int result);
}

interface KeyGetter<T, K> {
    K getKey(T o);
}

interface Comparer<K> {
    int compare(K o1, K o2);
}

class AscendingCompareStrategy implements CompareStrategy {
    @Override
    public int apply(int result) {
        return result;
    }
}

class DescendingCompareStrategy implements CompareStrategy {
    @Override
    public int apply(int result) {
        return -result;
    }
}

class StudentIDKey implements KeyGetter<Student, Integer> {
    @Override
    public Integer getKey(Student o) {
        return o.getStudentID();
    }
}

class StudentFirstNameKey implements KeyGetter<Student, String> {
    @Override
    public String getKey(Student o) {
        return o.getFirstName();
    }
}

class StudentLastNameKey implements KeyGetter<Student, String> {
    @Override
    public String getKey(Student o) {
        return o.getLastName();
    }
}

class IntComparer implements Comparer<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

class StringComparer implements Comparer<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

public class Main {

    public static void main(String[] args) {
	    List<Student> list =
				Arrays.asList(new Student[]{
						new Student(3, "William", "Flageol"),
						new Student(1, "John", "Wick"),
						new Student(2, "Jim", "Raynor"),
						new Student(4, "Bruce", "Wayne")
				});

	    Collections.sort(list, new NewSort(
	            new StudentIDKey(),
                new IntComparer(),
                new DescendingCompareStrategy()
        ));

	    // Version conviviale à utiliser.
        Collections.sort(list, Comparator.comparingInt(Student::getStudentID));
        Collections.sort(list, Comparator.comparing(Student::getFirstName));
        Collections.sort(list, Comparator.comparing(Student::getLastName));
        Collections.sort(list, (s1, s2) -> s1.getStudentID() - s2.getStudentID());

        // Descendant.
        Collections.reverse(list);

	    System.out.printf("Sorted list: %s", list);
    }
}
