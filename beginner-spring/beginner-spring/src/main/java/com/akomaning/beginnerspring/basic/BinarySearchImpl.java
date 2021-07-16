package com.akomaning.beginnerspring.basic;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //@Autowired
    //private SortAlgorithm sortAlgorithm;

    //☝🏼 the top one is used when any of the classes that implements the SortAlgorithm interface as a
    //@Primary annotation, if not the one below is used : by specifying the name of the class as the
    //Interface type
    //@Autowired
    //private SortAlgorithm bubbleSortAlgorithm;

    @Autowired
    @Qualifier("quick")
    private SortAlgorithm sortAlgorithm;

    /**
     *  setter Injection also the same as defining the autowired on the private property above alone
     *  public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
     *         this.sortAlgorithm = sortAlgorithm;
     *     }
     */


    /**
     * 👇 Constructor Injection
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        super();
        this.sortAlgorithm = sortAlgorithm;
    }
    **/
    public int binarySearch(int[] arrNum, int numToSearch) {
        //Sort the array (Implement Binary Search Algorithm)
//        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        int[] sortedArrNums = sortAlgorithm.sort(arrNum);
        System.out.println(sortAlgorithm);
        //Search the array
        //Return the result
        return 3;
    }

    //postConstruct is called before any Bean in this class is created (in the context) just
    //like ngOnit() method in Angular
    @PostConstruct()
    void methodCalledBeforeBeanIsCreated() {
        logger.info("Component is about to be created 😀...");
    }

    //postConstruct is called before any Bean in this class is created (in the context) just
    //like ngOnit() method in Angular
    @PreDestroy()
    void methodCalledBeforeBeanIsDestroy() {
        logger.info("Component is about to be removed 😢...");
    }
}
