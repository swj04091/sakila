package sakila.business.service;

import java.util.List;

import sakila.business.model.Rental;
import sakila.business.model.RentalDao;

public class RentalService {
	private RentalDao rentalDao;
	
	public void returnVideo(int rentalId) {
		System.out.println("rental Service!");
		System.out.println("Service RentalId: "+rentalId);
		
		rentalDao = new RentalDao();
		rentalDao.returnVideo(rentalId);
	}
	
	public List<Rental> selectRental(){
		System.out.println("Rental Service!");
		
		rentalDao = new RentalDao();
		List<Rental> list = rentalDao.selectRentalList();
		System.out.println("Rental List: "+list);
		
		return list;
	}
}
