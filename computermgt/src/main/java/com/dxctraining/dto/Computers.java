package com.dxctraining.dto;
import org.springframework.stereotype.Component;

import com.dxctraining.computer.entities.Computer;

	
	@Component
	public class Computers {

		public static ComputerReq computerReq(Computer computer, int supplierId) {
			ComputerReq computerReq = new ComputerReq(computer.getId(), computer.getName(), computer.getDisksize());
			computerReq.setSupplierId(supplierId);
			return computerReq;
		}
	}

