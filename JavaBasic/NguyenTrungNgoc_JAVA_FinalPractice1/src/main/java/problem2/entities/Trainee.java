package problem2.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Trainee implements Comparable<Trainee> {
    private String account;
    private String full_name;
    private boolean gender;
    private Date birth_date;
    private String phone_number;
    private String gpa;
    //private List<String> status =  new ArrayList<>(Arrays.asList("active","in-active"));
    private String status;

    public Trainee() {
    }

    public Trainee(String account, String full_name, boolean gender, Date birth_date, String phone_number, String gpa, String status) {
        this.account = account;
        this.full_name = full_name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.phone_number = phone_number;
        this.gpa = gpa;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "account='" + account + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", birth_date=" + birth_date +
                ", phone_number='" + phone_number + '\'' +
                ", gpa='" + gpa + '\'' +
                ", status=" + status +
                '}';
    }

    public String toStringMinimum() {
        return "Trainee{" +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", birth_date=" + birth_date +
                ", gpa='" + gpa + '\'' +
                '}';
    }

    @Override
    public int compareTo(Trainee o) {
        return 0;
    }
}
