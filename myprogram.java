import java.util.*; 
import java.lang.*; 
import java.math.BigInteger;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.*; 
import java.lang.*; 
class MainBlock{ private int num; private String previousHash; 
private Transaction transaction; public 
MainBlock() { 
    
}
public MainBlock(int num,String previousHash,Transaction transaction) 
{
    this.num=num; 
    this.previousHash=previousHash; 
    this.transaction=transaction; }
    public void getTransaction(){ System.out.print(previousHash+" "); 
    transaction.display(); }
    public void getTransaction1()
    { System.out.print(previousHash+" "); 
    transaction.display1(); } }
    class SideBlock{ public int num; 
    public String previousHash; 
    public Transaction2 transaction; 
    public SideBlock() { }
    public SideBlock(int num,String previousHash,Transaction2 transaction) 
    { this.num=num; this.previousHash=previousHash; this.transaction=transaction; }
    public void getTransaction(){ System.out.print(previousHash+" "); 
    transaction.display(); }
    public void setModify1(int c,int r)
    { if(c==3) { transaction.age=r; }else if(c==4) { transaction.zipcode=r; } }public void setModify2(int c,String r) { if(c==1) { transaction.name=r; }else if(c==2) { transaction.gender=r; }else if(c==5) { transaction.City=r; }else if(c==6) { transaction.disease=r; } }public String getHash() { String s=Integer.toString(transaction.tempid)+Integer.toString(transaction.id)+transaction.name+transaction.gende r+Integer.toString(transaction.age)+Integer.toString(transaction.zipcode)+transaction.City+ transaction.disease; return myprogram.encryptThisString(s); } }class Transaction{ int id; String name; String gender; String age; int zipcode; String City; String disease; public void setValue(int id,String name,String gender,String age,int zipcode,String City,String disease) {
this.id=id; this.name=name; this.gender=gender; this.age=age; this.zipcode=zipcode; this.City=City; this.disease=disease; }public void display() { System.out.println(id+" "+name+" "+gender+" "+age+" "+zipcode+" "+City+" "+disease); }public void display1() { System.out.println(id+" "+"******"+" "+gender+" "+age+" "+zipcode+" "+City+" "+disease); } }class Transaction2{ int tempid; int id; String name; String gender; int age; int zipcode; String City; String disease; public void setValue(int tempid,int id,String name,String gender,int age,int zipcode,String City,String disease) { this.tempid=tempid; this.id=id; this.name=name; this.gender=gender; this.age=age; this.zipcode=zipcode; this.City=City; this.disease=disease; }public void display() { System.out.println(tempid+" "+id+" "+name+" "+gender+" "+age+" "+zipcode+" "+City+" "+disease); } }public class myprogram{ public static String encryptThisString(String input) {
    try { MessageDigest md = MessageDigest.getInstance("SHA-512"); byte[] messageDigest = md.digest(input.getBytes()); BigInteger no = new BigInteger(1, messageDigest); String hashtext = no.toString(16); // Add preceding 0s to make it 32 bit 
    while (hashtext.length() < 32) { hashtext = "0" + hashtext; }// return the HashText return hashtext; }// For specifying wrong message digest algorithms catch (NoSuchAlgorithmException e) { throw new RuntimeException(e); } }public static void main(String args[]) { Scanner scan=new Scanner(System.in); System.out.println("Enter the no.of transactions:- "); int n= scan.nextInt(); Transaction[] trans=new Transaction[n]; Transaction2[] trans2=new Transaction2[n]; MainBlock mblock[]=new MainBlock[n]; SideBlock sblock[]=new SideBlock[n]; int n1=42; for(int w=0;w<n;w++) { //System.out.println("Enter the id:- "); int id=scan.nextInt(); //System.out.println("Enter the name:- "); String name=scan.next(); //System.out.println("Enter the gender:- "); String gender=scan.next(); //System.out.println("Enter the age:- "); int age=scan.nextInt(); //System.out.println("Enter the zipcode:- "); int zip=scan.nextInt(); //System.out.println("Enter the City:- ");
    String city=scan.next(); //System.out.println("Enter the disease:- "); 
    String disease=scan.next(); trans[w]=new Transaction(); trans2[w]=new Transaction2(); int tempid1=id+n1; n1=n1+17; trans2[w]=new Transaction2(); trans2[w].setValue(tempid1,id, name, gender, age, zip, city, disease); String st2=Integer.toString(tempid1)+Integer.toString(id)+name+gender+Integer.toString(age)+Integer.toString(zi p)+city+ disease; gender="ANY_GENDER"; int temp=zip; for(int i=0;i<10;i++) { if((temp-i)%10==0) { zip=temp-i; break;} }String age1="<"; int temp6=age; for(int i=0;i<10;i++) { if((temp6+i)%5==0) { String s=Integer.toString(temp6+i); age1=age1+s; break; } }String st1=Integer.toString(id)+name+gender+age1+Integer.toString(zip)+city+ disease; trans[w].setValue(tempid1, name, gender, age1, zip, city, disease); MainBlock temp1=new MainBlock(); SideBlock temp2=new SideBlock(); if(w==0) { mblock[w]=new MainBlock(w,"0",trans[w]); sblock[w]=new SideBlock(w,"0",trans2[w]); } else { temp1=mblock[w-1]; mblock[w]=new MainBlock(w,encryptThisString(st1),trans[w]); temp2=sblock[w-1];
    sblock[w]=new SideBlock(w,encryptThisString(st2),trans2[w]); } }System.out.println("Contents of BlockChain1--->\n"); for(int i=0;i<n;i++) { mblock[i].getTransaction(); }for(int i=0;i<n;i++) { mblock[i].getTransaction1(); }System.out.println("Contents of BlockChain2 --->"); for(int i=0;i<n;i++) { sblock[i].getTransaction(); }System.out.print("Perform The Operations:-\n 1.Modify the data\n2.Verify the blockchain"); do { System.out.print("\nEnter your choice:- "); int choice=scan.nextInt(); switch(choice) { case 1: System.out.print("\n1. NAME 2.GENDER 3.AGE 4.ZIPCODE 5.ADDRESS 6.DISEASE\n Enter the field to be altered:- "); int choice1=scan.nextInt(); System.out.print("Enter the ID for the modification:- "); int id1=scan.nextInt(); switch(choice1) { case 1: System.out.print("Enter the new name:- "); String f=scan.next(); for(int i=0;i<n;i++) { if(trans2[i].id==id1) { trans2[i].name=f; sblock[i].setModify2(choice1,f); } } break; case 2: System.out.print("Enter the gender:- ");
    String fi=scan.next(); for(int i=0;i<n;i++) { if(trans2[i].id==id1) { trans2[i].gender=fi; sblock[i].setModify2(choice1,fi); } } break; case 3: System.out.print("Enter the age:- "); int fq=scan.nextInt(); for(int i=0;i<n;i++){ if(trans2[i].id==id1) { trans2[i].age=fq; sblock[i].setModify1(choice1,fq); } } break; case 4: System.out.print("Enter the Zipcode:- "); int fr=scan.nextInt(); for(int i=0;i<n;i++) { if(trans2[i].id==id1) { trans2[i].zipcode=fr; sblock[i].setModify1(choice1,fr); } } break; case 5: System.out.print("Enter the City:- "); String fa=scan.next(); for(int i=0;i<n;i++) { if(trans2[i].id==id1) { trans2[i].City=fa; sblock[i].setModify2(choice1,fa); } } break; case 6: System.out.print("Enter the disease:- "); String fs=scan.next(); for(int i=0;i<n;i++)
    { if(trans2[i].id==id1) { trans2[i].disease=fs; sblock[i].setModify2(choice1,fs); } } break; default: System.out.println("Inavalid input\n"); break; } break; case 2: int flag=0; for(int i=1;i<n;i++) { String st=sblock[i-1].getHash(); if(st!=sblock[i].previousHash) { flag= 1; break; } }for(int i=0;i<n;i++) { sblock[i].getTransaction(); }System.out.println("\n"); for(int i=0;i<n-1;i++) { System.out.println(sblock[i].hashCode()); }if(flag==1) { System.out.println("\nBlock chain is modified"); } else { System.out.println("\nBlock Chain is safe"); } break; default:System.out.println("Invalid input\n"); break; } }while(true); }