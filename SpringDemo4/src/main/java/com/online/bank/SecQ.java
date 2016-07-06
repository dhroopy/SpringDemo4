package com.online.bank;

public class SecQ {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String mmname;

	public String Sec() {
    	
     	String un = this.uid;
     	String mmn = this.mmname;
     	
     	System.out.println("here1" + un);
     	boolean val = JDBC.mmvali(un, mmn);
     	System.out.println("here2" + un);
    	System.out.println(mmn);
    	
    	if (val == true) {
            return "success";
        } else {
            return "error";
        }
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMmname() {
		return mmname;
	}

	public void setMmname(String mmname) {
		this.mmname = mmname;
	}

}

