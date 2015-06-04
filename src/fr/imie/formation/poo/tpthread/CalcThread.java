/**
 * 
 */
package fr.imie.formation.poo.tpthread;

/**
 * @author Florent RICHARD
 *
 */
public class CalcThread extends Thread {
    private Integer tmpResult = 1;
    /**
     * 
     */
    public CalcThread() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public CalcThread(Runnable arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public CalcThread(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public CalcThread(ThreadGroup arg0, Runnable arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public CalcThread(ThreadGroup arg0, String arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public CalcThread(Runnable arg0, String arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     */
    public CalcThread(ThreadGroup arg0, Runnable arg1, String arg2) {
        super(arg0, arg1, arg2);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public CalcThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3) {
        super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the tmpResult
     */
    public final Integer getTmpResult() {
        return tmpResult;
    }

    /**
     * @param tmpResult the tmpResult to set
     */
    public final void setTmpResult(Integer tmpResult) {
        this.tmpResult = tmpResult;
    }
}
