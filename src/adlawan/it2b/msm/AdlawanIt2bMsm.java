
package adlawan.it2b.msm;
import java.util.Scanner;

public class AdlawanIt2bMsm {
    
    public static void main(String[] args) {
     int choice;
        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println(" 1. ADD");
            System.out.println(" 2. VIEW");
            System.out.println(" 3. UPDATE");
            System.out.println(" 4. DELETE");
            System.out.println(" 5. Exit");
        
            System.out.print("Enter choice: ");
            choice= sc.nextInt();   
            sc.nextLine();
            
            switch(choice){
                case 1:
                addCustomers(sc);
                break;
                
                case 2:
                   viewCustomers();
                   break;
                case 3:
                    updateCustomers();
                    break;
                case 4:
                    deleteCustomers();
                    break;
                case 5: 
                    System.out.println("Exit!!");
                    break;
                default:
                    System.out.println("Invalid Choice, PLease Try Again");
            
                    
                    
                    
            } 
        }while(choice != 5);
    
        
    }

 
        

    
      public static void addCustomers(Scanner sc) {
        System.out.println("Enter ID");
        int id = sc.nextInt();
        System.out.print("Enter First Name: ");
        String fname = sc.next();
        System.out.print("Enter Last Name: ");
        String lname = sc.next();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Gender");
        String Gender = sc.next();
        System.out.println("Enter Phone Number");
        int  number = sc.nextInt();
        System.out.println("Status");
        String status = sc.next();
        config conf = new config();
        String sql = "INSERT INTO tbl_members (c_id ,c_fname, c_lastname, c_age, c_gender, c_number, c_status) VALUES (?, ?, ?, ?, ?, ?, ? )";
        conf.addCustomers(sql,id ,fname, lname, age, Gender, number, status);
    }

    public static void viewCustomers() {
        String sqlQuery = "SELECT * FROM tbl_members";
        String[] columnHeaders = {"ID","firstName", "lastname", "age", "gender", "number", "status"};
        String[] columnNames = {"c_id","c_fname", "c_lastname", "c_age", "c_gender","c_number", "c_status"};
        config conf = new config();
        conf.viewCustomers(sqlQuery, columnHeaders, columnNames);
    
}
    
     public static void updateCustomers(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter new First Name: ");
        String cfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String clname = sc.next();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Gender");
        String Gender = sc.next();
        System.out.println("Phone Number");
        int number = sc.nextInt();
        System.out.print("Enter new Status: ");
        String cstatus = sc.next();
        
        String qry = "UPDATE tbl_members SET c_fname = ?, c_lastname = ?, c_age = ?, c_gender = ?, c_number = ?, c_status = ? WHERE c_id = ?";
        
        config conf = new config();
        conf.updateCustomers(qry, cfname, clname, age, Gender, number, cstatus, id);
        
    }
     public static void deleteCustomers(){
     
           Scanner sc = new Scanner (System.in);
           System.out.println("Enter the ID You want to delete");
           int id = sc.nextInt();
           
           String qry = "DELETE FROM tbl_members WHERE c_id = ?";
           
           config conf = new config();
           conf.deleteCustomers(qry, id);
     
     
     }
}


