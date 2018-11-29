package com.sparta.jas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SetList setList = new SetList();
        setList.setCoreSets();
        setList.setExpertLvExpansions();
        SetGenerator setGenerator = new SetGenerator(setList.getCoreShortList(), setList.getExpansionShortList());
        System.out.println(setGenerator.generateChaosStandard());
        System.out.println(setGenerator.generateScryfallLink());


//        System.out.println(setList.getCoreSets());
//        System.out.println(setList.getExpertLvExpansions());
    }
}
