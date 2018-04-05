function Teacher(teacherid,isteacherpass,email,pwd,nickname,realname,phonenum)
{
	this.teacherid=teacherid?teacherid:'';
	this.isteacherpass=isteacherpass?isteacherpass:'';
	
	this.email=email?email:'';
	this.pwd=pwd?pwd:'';
	
	this.nickname=nickname?nickname:'';
	this.realname=realname?realname:'';
	
	this.phonenum=phonenum?phonenum:'';
}
