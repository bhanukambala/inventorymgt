package com.dxctraining.computer.util;
import org.springframework.stereotype.Component;

import com.dxctraining.computer.dto.ComputerDto;
import com.dxctraining.computer.entities.Computer;

	
	@Component
	public class ComputerUtil {

		public static ComputerDto computerDto(Computer computer, int supplierId) {
			ComputerDto computerReq = new ComputerDto(computer.getId(), computer.getName(), computer.getDisksize());
			computerReq.setSupplierId(supplierId);
			return computerReq;
		}
	}

