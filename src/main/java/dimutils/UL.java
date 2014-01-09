package dimutils;

/**
 * Utility class with static methods
 * @author Ernesto Guevara
 */
public class UL {
    /**
     * Returns index of the first element inside of haystack which is equal(CaseInsensitive) to the needle. 
     * @return -1 on error  
     *         [0.. length-1]
     * 
     */
    public static int arrayContainsStringCaseInsensitive(String[] haystack, String needle){
        for(int i = 0  ; i < haystack.length ; i++){ 
              if ( needle.equalsIgnoreCase(haystack[i])){
                  return i;
              }
        }
        return -1;
    }

    
    
    /**
     * Searches haystack stringar for the first exact match with needle and returns index or -1 when not found.
     * @param haystack
     * @param needle
     * @return -1 when not found, valid index when found.
     */
    public static int arrayContainsStringExactCase(String[] haystack, String needle) {
        for(int i = 0  ; i < haystack.length ; i++){ 
              if ( needle.equals(haystack[i])){
                  return i;
              }
        }
        return -1;
    }
       

    /*
     * Returns first index of stringar which element contains(!) the needle. (as a asubstring
     * @return -1 on error
     */
    public static int arrayContainsSubstringCaseInsensitive(String[] haystack, String needleSubstring){
         // we convert to lowercase so that we can make case insensitive compares
        needleSubstring = needleSubstring.toLowerCase(); 
        for(int i = 0  ; i < haystack.length ; i++){ 
              String haystackString = haystack[i].toLowerCase();
              if ( haystackString.contains(needleSubstring) ){
                   return i;
              }
        }
        return -1;
    }
    
    
   /*
    * Checks whether [headers] contains any of the keywords ?
    */
   public static boolean arrayRemainingElementsContainOneOfTheKeywordsCaseInsensitive(String[] headers, 
                                                                                      int itemToSkip, 
                                                                                      String[] ALLOWED_KEYWORDS)    
   {
      for(int i =0  ; i < headers.length ; i++){    
           if ( i == itemToSkip ) continue; // skip the skipping item
           if ( stringContainsKeywordsCaseInsensitive(headers[i], ALLOWED_KEYWORDS) ){
               return true;
           }
      }
      return false;
   }

   /*
    * Checks whether string contains any of the keywords
    */
   public static boolean stringContainsKeywordsCaseInsensitive(String string, String[] ALLOWED_KEYWORDS) {
         String lcaseString = string.toLowerCase();
         String kw;
         for(int i = 0 ; i < ALLOWED_KEYWORDS.length ; i++){
              kw = ALLOWED_KEYWORDS[i];
              if ( lcaseString.contains(kw.toLowerCase())){
                   return true;
              }
         }
         return false;
    }
    
    
   
    /**
     * Converts stringar to string in form '[value1,value2]'
     * @param stringar
     * @return 
     */
    public static String stringar2str(String[] stringar) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for(int i = 0 ; i < stringar.length ; i++){
            if ( i >0 ){
                builder.append(',');
            }
            builder.append(stringar[i]);
        }
        builder.append(']');
        return builder.toString();
    }
    
    
    
    public static void  p(String s){
        System.out.print(s);
    }
    
    public static void pln(String s){
         System.out.println(s);
    }
    
    
    
    public static void pln(String[] stringar){
        pln(stringar, ", ");
    }
    
    public static void pln(String[] stringar, String delimiter){
         if ( stringar == null){
              pln("null");
              return;
         }
         
         for(int i = 0 ; i < stringar.length ; i++){
             if ( i > 0 ){
                  p(delimiter);
             }
             p(stringar[i]);
         }
         p("\n");
    }

    
    public static void printCWD(){
         String cwd = System.getProperty("user.dir");
         pln("Current working directory is: [" + cwd + "]");
    }

    /**
     * Joins two stringars into one new stringar.
     * 
     * Always returns a new copy of the array (even if for example stringar1 was empty, and 
     * end result is same as stringar2 array, it will still be copied to the new one.
     * 
     * Also we may result in valid empty (0 size) array.
     * 
     * @param stringar1 non-null (but CAN be empty)
     * @param stringar2 non-null (but CAN be empty)
     * @return 
     */
    public static String[] joinStringars(String[] stringar1, String[] stringar2) {
        // TODO: implement joinStringars
        int newLength = stringar1.length + stringar2.length;
        String[] joined = new String[newLength];
        int j = 0;
        for(int i = 0 ; i < stringar1.length ; i++){
            joined[j++] = stringar1[i];
        }
        
        for(int i = 0 ; i < stringar2.length ; i++){
            joined[j++] = stringar2[i];
        }
        return joined;
    }

}// UL class
