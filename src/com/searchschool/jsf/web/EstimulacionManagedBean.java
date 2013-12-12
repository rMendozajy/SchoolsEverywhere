package com.searchschool.jsf.web;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.searchschool.bean.Colegio;
import com.searchschool.jpa.ColegioDAOImpl;

@ManagedBean (name="ESTIMULACION")
@SessionScoped
public class EstimulacionManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Colegio> schools;
	private Colegio selectedSchool;
	private List<Colegio> filteredSchools;
	private SelectItem[] typeOptions; 
	private final static String[] types;
	
	private List<String> sortingFields;
	private String selectedField, currentSortField;
	private boolean asc;
	private ColegioDAOImpl schoolImpl;
	
	static {
		types = new String[10];
		types[0] = "Publico Religioso";
		types[1] = "Privado Religioso";
		types[2] = "Publico";
		types[3] = "Privado";
		types[4] = "Concertado";
		types[5] = "Pre-universitario";
	}

	public void sortSchools() {
		if(selectedField.equals("Valoración"))
		{
			schools = schoolImpl.sortTypeByField("Estimulacion","qvaloracionPromedio", false);
			return;
		}
		if(selectedField.equals("Nombre"))
		{
			schools = schoolImpl.sortTypeByField("Estimulacion","ncolegio", true);
			return;
		}
		if(selectedField.equals("Tipo de colegio"))
		{
			schools = schoolImpl.sortTypeByField("Estimulacion","tipoColegio", true);
			return;
		}
	}
	
	private int count;
	public int getCount() {
	return count;
	}
	public void setCount(int count) {
	this.count = count;
	}
	public void increment() {
	count++;
	}
	public EstimulacionManagedBean() {
		currentSortField="Nombre";
		asc=true;
		schools = new ArrayList<Colegio>();
		schoolImpl=ColegioDAOImpl.getInstance();
		schools=schoolImpl.findbytype("Estimulacion");
		typeOptions = createFilterOptions(types);  
		sortingFields = new ArrayList<String>();
		sortingFields.add("Nombre");
		sortingFields.add("Valoración");
		sortingFields.add("Tipo de colegio");
	}

	private SelectItem[] createFilterOptions(String[] data)  {  
        SelectItem[] options = new SelectItem[data.length + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.length; i++) {  
            options[i + 1] = new SelectItem(data[i], data[i]);  
        }  
  
        return options;  
    }
	public String showDetails(){
		return "detalles";
	}

	/**
	 * @return the schools
	 */
	public List<Colegio> getSchools() {
		return schools;
	}


	/**
	 * @param schools the schools to set
	 */
	public void setSchools(List<Colegio> schools) {
		this.schools = schools;
	}


	/**
	 * @return the selectedSchool
	 */
	public Colegio getSelectedSchool() {
		return selectedSchool;
	}


	/**
	 * @param selectedSchool the selectedSchool to set
	 */
	public void setSelectedSchool(Colegio selectedSchool) {
		this.selectedSchool = selectedSchool;
	}


	/**
	 * @return the filteredSchools
	 */
	public List<Colegio> getFilteredSchools() {
		return filteredSchools;
	}


	/**
	 * @param filteredSchools the filteredSchools to set
	 */
	public void setFilteredSchools(List<Colegio> filteredSchools) {
		this.filteredSchools = filteredSchools;
	}


	/**
	 * @return the typeOptions
	 */
	public SelectItem[] getTypeOptions() {
		return typeOptions;
	}


	/**
	 * @param typeOptions the typeOptions to set
	 */
	public void setTypeOptions(SelectItem[] typeOptions) {
		this.typeOptions = typeOptions;
	}


	/**
	 * @return the sortingFields
	 */
	public List<String> getSortingFields() {
		return sortingFields;
	}


	/**
	 * @param sortingFieds the sortingFields to set
	 */
	public void setSortingFields(List<String> sortingFields) {
		this.sortingFields = sortingFields;
	}


	/**
	 * @return the selectedField
	 */
	public String getSelectedField() {
		return selectedField;
	}


	/**
	 * @param selectedField the selectedField to set
	 */
	public void setSelectedField(String selectedField) {
		this.selectedField = selectedField;
	}


	/**
	 * @return the currentSortField
	 */
	public String getCurrentSortField() {
		return currentSortField;
	}


	/**
	 * @param currentSortField the currentSortField to set
	 */
	public void setCurrentSortField(String currentSortField) {
		this.currentSortField = currentSortField;
	}


	/**
	 * @return the asc
	 */
	public boolean isAsc() {
		return asc;
	}


	/**
	 * @param asc the asc to set
	 */
	public void setAsc(boolean asc) {
		this.asc = asc;
	}


	/**
	 * @return the schoolImpl
	 */
	public ColegioDAOImpl getSchoolImpl() {
		return schoolImpl;
	}


	/**
	 * @param schoolImpl the schoolImpl to set
	 */
	public void setSchoolImpl(ColegioDAOImpl schoolImpl) {
		this.schoolImpl = schoolImpl;
	}


	/**
	 * @return the types
	 */
	public static String[] getTypes() {
		return types;
	}

}