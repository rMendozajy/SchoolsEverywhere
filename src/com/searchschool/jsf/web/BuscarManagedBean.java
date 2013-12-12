package com.searchschool.jsf.web;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.searchschool.bean.Colegio;
import com.searchschool.jpa.ColegioDAO;
import com.searchschool.jpa.ColegioDAOImpl;

@ManagedBean (name="BUSCAR")
@SessionScoped
public class BuscarManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Colegio> schools;
	private Colegio selectedSchool;
	private List<Colegio> filteredSchools;
	private SelectItem[] typeOptions; 	
	private List<String> sortingFields;
	private String selectedField, currentSortField;
	private boolean asc;
	private ColegioDAO colegioif;
	/**
	 * @return the colegioif
	 */
	public ColegioDAO getColegioif() {
		return colegioif;
	}

	/**
	 * @param colegioif the colegioif to set
	 */
	public void setColegioif(ColegioDAO colegioif) {
		this.colegioif = colegioif;
	}

	private String name;
	
	
	public void sortSchools() {
		if(selectedField.equals("Valoración"))
		{
			schools = colegioif.sortByField("qvaloracionPromedio", false);
			return;
		}
		if(selectedField.equals("Nombre"))
		{
			schools = colegioif.sortByField("ncolegio", true);
			return;
		}
		if(selectedField.equals("Tipo de colegio"))
		{
			schools = colegioif.sortByField("tipoColegio", true);
			return;
		}
	}
	
	public void search() {
		System.out.println("Enpieza a buscars");
		schools=colegioif.findbyName(name);
		System.out.println(schools.size());
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
	public BuscarManagedBean() {
		currentSortField="Nombre";
		asc=true;
		schools = new ArrayList<Colegio>();
		colegioif=ColegioDAOImpl.getInstance();
		schools=colegioif.sortByField("ncolegio", true);  
		sortingFields = new ArrayList<String>();
		sortingFields.add("Nombre");
		sortingFields.add("Valoración");
		sortingFields.add("Tipo de colegio");
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}