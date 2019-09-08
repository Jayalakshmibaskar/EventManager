<?php
$servername = "localhost";
$username = "root";

$password = "";
$dbname="learn_db";
$conn=mysqli_connect($servername,$username,$password,$dbname);
if(!$conn){
    die("Connecton failed:" .mysqli_connect_error());
}
else{
     $username=$_POST['username'];
     $email=$_POST['email'];
     $mobile=$_POST['mobile'];
     $college=$_POST['college'];
     $dept=$_POST['dept'];
     $year=$_POST['year'];
     $insert="insert into reg_form (name,email,mobile,college,dept,year) values ('$username','$email','$mobile','$college','$dept','$year')";
     $result=mysqli_query($conn,$insert);
     if(!$result){
         echo "error".mysqli_error($conn);
     }
     else{
         echo "success";
    }}
mysqli_close($conn);
?>
