package com.web.mall.model;

import org.springframework.web.multipart.MultipartFile;

public class Manage_ImageDTO {
	private int ImageID;
	private int ReferencesID;
	private String IDType;
	private String FileName;
	private String FileURL;//웹에서 다운로드시 이용되는 경로
	private String RealPath;//실질적으로 파일이 저장되는 경로
	private MultipartFile File;
	
	public int getImageID() {
		return ImageID;
	}
	public void setImageID(int imageID) {
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
	public String getFileURL() {
		return FileURL;
	}
	public void setFileURL(String fileURL) {
		FileURL = fileURL;
	}
	public String getFullPath() {
		return FileURL + "/" + FileName;
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
		return "ImageDTO [ImageID=" + ImageID + ", ReferencesID=" + ReferencesID + ", IDType=" + IDType + ", FileName="
				+ FileName + ", FileURL=" + FileURL + ", File=" + File + "]";
	}
}
