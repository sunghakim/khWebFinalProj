package com.web.mall.model;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public class Manage_ImageDTO {
	private BigDecimal ImageID;
	private int ReferencesID;
	private String IDType;
	private String FileName;
	private String FileURL;
	private String RealPath;//실질적으로 파일이 저장되는 경로
	private MultipartFile File;
	
	public BigDecimal getImageID() {
		return ImageID;
	}
	public void setImageID(BigDecimal imageID) {
		ImageID = imageID;
	}
	public int getReferencesID() {
		return ReferencesID;
	}
	public void setReferencesID(int referencesID) {
		ReferencesID = referencesID;
	}
	public String getIDType() {
		return IDType;
	}
	public void setIDType(String iDType) {
		IDType = iDType;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileNameExtension() {
		return FileName.substring(FileName.lastIndexOf(".") + 1);
	}
	public String getFileURL() {
		return FileURL;
	}
	public void setFileURL(String fileURL) {
		FileURL = fileURL;
	}
	public String getDownloadPath() {
		return FileURL + "/" + ImageID + "." + getFileNameExtension();
	}
	public String getRealSavedPath() {
		return RealPath + IDType;
	}
	public String getRealSavedFile() {
		return getRealSavedPath() + "/" + ImageID + "." + getFileNameExtension();
	}
	public String getRealPath() {
		return RealPath;
	}
	public void setRealPath(String realPath) {
		RealPath = realPath;
	}
	public MultipartFile getFile() {
		return File;
	}
	public void setFile(MultipartFile file) {
		this.File = file;
	}
	@Override
	public String toString() {
		return "Manage_ImageDTO [ImageID=" + ImageID + ", ReferencesID=" + ReferencesID + ", IDType=" + IDType
			+ ", FileName=" + FileName + ", FileURL=" + FileURL	+ ", RealPath=" + RealPath + 
			", File=" + File + "]";
	}
	
}
