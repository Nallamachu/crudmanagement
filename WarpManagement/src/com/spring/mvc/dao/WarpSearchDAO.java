package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.beans.DictionarySearch;

public interface WarpSearchDAO {

	List<DictionarySearch> getAllData();

	DictionarySearch getDataById(int id);

	void saveData(DictionarySearch search);

	void updateData(DictionarySearch search);

	void deleteDataById(int id);

}
