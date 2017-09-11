/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsystem;


public class Train {
    
    private String fname;
    private String lname;
    private String adult;
    private String child;
    private String from;
    private String to;
    private String classs;
    private String ticket_type;
    private int ticket_number;
    private double pricee;
    private String time;
    private String date;
    private double sub_total;
     private double tax;
    
    public Train (String tfname,String tlname,String tadult,String tchild,String tfrom,String tto,String tclasss,String tticket_type,
                   int tticket_number, String tdate, String ttime, double tpricee,double tsub_total,double ttax ){
        
        this.fname = tfname;
        this.lname = tlname;
        this.adult = tadult;
        this.child = tchild;
        this.from = tfrom;
        this.to = tto;
        this.classs = tclasss;
        this.ticket_type= tticket_type;
        this.ticket_number= tticket_number;
        this.pricee = tpricee;
        this.time = ttime;
        this.date = tdate;
        this.sub_total = tsub_total;
        this.tax = ttax;
        
        
    }

    Train(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, int aInt, String string7, String string8, String string9, double parseDouble,double parseDouble1,double parseDouble2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public String getFname()
   {
       return fname;
   }
   
   public String getLname()
   {
       return lname;
   }
    
   public String getAdult()
   {
       return adult;
   }
   
   public String getChild()
   {
       return child;
   }
   
   public String getFrom()
   {
       return from;
   }
   public String getTo()
   {
       return to;
   }
   
   public String getClasss()
   {
       return classs;
   }
    
   public String getTicketType()
   {
       return ticket_type;
   }
   
   public int getTicketNumber()
   {
       return ticket_number;
   }
   
   public double getPrice()
   {
       return pricee;
   }
   public String getTime()
   {
       return time;
   }
   
   public String getDate()
   {
       return date;
   }
    
  public double getSub_Total()
   {
       return sub_total;
   }
  public double getTax()
   {
       return tax;
   }
            
            }
