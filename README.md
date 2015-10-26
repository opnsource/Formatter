>>This project is mainly to solve the problem formatting applied in different regions or countries in the format generated , you can set the default Locale by **Formatter.init (Locale locale)** method . Secondly, for the pattern caching strategy used to prevent multiple objects to create a format .

# Format

##DateFormtter
 
      DateFormatter.format(new Date(),"yyyy-MM-dd HH:mm:ss");
 
      DateFormatter.format( System.currentTimeMillis(),""yyyy-MM-dd HH:mm:ss"");
 
### Appoint a locale:
 
      DateFormatter.format(Locale.US,new Date(),"yyyy-MM-dd HH:mm:ss");
 
### No CACHE:
 
      DateFormatter.format(Locale.US,new Date(),"yyyy-MM-dd HH:mm:ss",false);
 
##NumberFormatter

      NumberFormatter.format(10.00f,"#0.00MB");
 
      NumberFormatter.format(10.00f,"#0.00MB",true);

###No cache:
 
      NumberFormatter.format(10.00f,"#0.00MB",false);
 
##StringFormatter

      StringFormatter.format("%s,%s","Hello","java");

###Appoint a locale:
  
      StringFormatter.format(Locale.US,"%s,%s","Hello","java");
