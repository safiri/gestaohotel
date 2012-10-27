package com.jhotel.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DataUtil {

   private final LocalDate dias;

   public DataUtil(final String data) {      
      final DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
      final DateTime dateTime = dtf.parseDateTime(data);
      dias = dateTime.toLocalDate();
   }

   public final boolean apos(final DataUtil data) {
      return dias.isAfter(data.dias);
   }

   public final boolean antes(final DataUtil data) {
      return dias.isBefore(data.dias);
   }

   @Override
   public final boolean equals(final Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final DataUtil other = (DataUtil) obj;
      if (dias == null) {
         if (other.dias != null) {
            return false;
         }
      } else if (!dias.equals(other.dias)) {
         return false;
      }
      return true;
   }

   @Override
   public final String toString() {
      return dias.toString("dd/MM/yyyy");
   }

   public static final DataUtil getDataHoje() {
      return new DataUtil(LocalDate.now().toString("dd/MM/yyyy"));
   }
}
