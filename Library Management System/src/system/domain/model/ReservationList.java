package system.domain.model;

import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class ReservationList.
 */
public class ReservationList
{
   
   /** The reservation list. */
   private static ArrayList<Reservation> reservationList;

   /**
    * Instantiates a new reservation list.
    */
   public ReservationList()
   {
      reservationList = new ArrayList<Reservation>();
   }

   /**
    * Adds the reservation.
    *
    * @param email the email
    * @param dateFrom the date from
    * @param reservationID the reservation id
    * @param itemID the item id
    */
   public static void addReservation(String email, MyDate dateFrom,
         int reservationID, int itemID)
   {
	   Reservation reservation = new Reservation(email, dateFrom, reservationID, itemID);
	   reservationList.add(reservation);
   }
   
   /**
    * Gets the size.
    *
    * @return the size
    */
   public int getSize() {
	return reservationList.size();
}


   /**
    * Removes the reservation by id.
    *
    * @param reservationID the reservation id
    * @return the reservation
    */
   public static Reservation removeReservationByID(int reservationID)
   {
      if (!isEmpty())
      {
         for (int i = 0; i < reservationList.size(); i++)
         {
            if (reservationList.get(i).getReservationID() == reservationID)
            {
              return reservationList.remove(i);
            }
         }
      }
      else
         System.out.println("There is no reservation Like that");
      return null;
   }

   /**
    * Checks if is empty.
    *
    * @return true, if is empty
    */
   private static boolean isEmpty()
   {
      if (reservationList.size() < 1)
         return true;
      else
         return false;
   }

   /**
    * Gets the list of reservations.
    *
    * @return the list of reservations
    */
   public ArrayList<Reservation> getListOfReservations()
   {
	   return reservationList;
   }
   
   /**
    * Gets the reservation by id.
    *
    * @param reservationID the reservation id
    * @return the reservation by id
    */
   public Reservation getReservationByID(int reservationID) {
	for (int i = 0; i < reservationList.size(); i++) {
		if(reservationList.get(i).getReservationID()== reservationID)
		{
			return reservationList.get(i);
		}
	}
	return null;
}
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      String s = "";
      if (reservationList.size() > 0)
      {

         for (int i = 0; i < reservationList.size(); i++)
         {
            s += reservationList.get(i) + "\n";
         }
      }
      else
         return "no borrower in this list";
      return s;

   }
}
