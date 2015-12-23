package com.example.zhangbin.pulltorefreshing;
/** 
 * @ClassName: LoginBean 
 * @Description: Login vso返回信息解析bean
 * @date 2015年11月25日 上午10:29:28
 *  
 * @author leobert.lan
 * @version 1.0
 */
public class DirItemBean {
	
	private String checksum; 
	
	private String name;
	
	private String path;
	
	private String type;
	
	private String owner;
	
	private long size;
	
	private String datetime;
	
	private int flag;
	
	private String descendantFiles;
	
	private String contentType;
    private String icon;
	
	
	/**
	 * isOpen:是否打开 
	 */
	private boolean isOpen = false;

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getDescendantFiles() {
		return descendantFiles;
	}

	public void setDescendantFiles(String descendantFiles) {
		this.descendantFiles = descendantFiles;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	
	

}
