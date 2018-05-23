package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.beans.DictionarySearch;
import com.spring.mvc.dao.WarpSearchDAO;

@RestController
public class WarpSearchController {
	@Autowired
	WarpSearchDAO searchDAO;

	@RequestMapping("/getalldata")
	public @ResponseBody List<DictionarySearch> getAllData() {
		return searchDAO.getAllData();
	}

	@RequestMapping("/getdatabyid/{id}")
	public @ResponseBody DictionarySearch getDataById(@PathVariable("id") int id) {
		return searchDAO.getDataById(id);
	}

	@RequestMapping(value = "/postdata", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postData(@RequestBody DictionarySearch search) {
		searchDAO.saveData(search);
	}

	@RequestMapping(value = "/updatedata", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateData(@RequestBody DictionarySearch search) {
		searchDAO.updateData(search);
	}

	@RequestMapping(value = "/deletedatabyid/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDataById(@PathVariable("id") int id) {
		searchDAO.deleteDataById(id);
	}
}
