package com.miniproject.miniproject;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

@Service
public class RequestService {
	@Autowired
	private RequestRepository repo;

	public Page<Request> listAll(int pageNum, String sortField, String sortDir, String keyword) {

		Pageable pageable = PageRequest.of(pageNum - 1, 10,
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
						: Sort.by(sortField).descending());

		if (keyword != null) {
			return repo.findAll(keyword, pageable);
		}
		return repo.findAll(pageable);
	}

	public void save(Request request) {
		repo.save(request);
	}

	public Request get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
