import java.util.*;

public class Dispatcher {
	static int currentTime;
	Scheduler scheduler;
	List<Process> processList;

	public Queue<Process> realTimeQueue;

	public Dispatcher(List<Process> list) {
		this.processList = list;
		realTimeQueue = new LinkedList<>();
		scheduler = new Scheduler();
		currentTime = 0;
	}

	public void run() {

		// Processler bitinceye kadar ayni islemleri yapıyoruz
		while (!processList.isEmpty() || !scheduler.priorityQueue0.isEmpty() || !scheduler.priorityQueue1.isEmpty()
				|| !scheduler.priorityQueue2.isEmpty() || !scheduler.priorityQueue3.isEmpty()) {
			for (var item : processList) {
				scheduler.addProcess(item);
			}

			// Onceliklerine gore kuyruklari dolasiyoruz

			if (!scheduler.priorityQueue0.isEmpty()) {
				Process tempProcess = scheduler.priorityQueue0.element(); // kuyrugun ilk elemanini aldik

				// State 0 ise baslamadi demektir. Burada baslatiyoruz
				if (tempProcess.getState() == 0) {
					System.out.println(tempProcess.getColor() + currentTime + " sn proses basladi (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
					tempProcess.setProcessTime(tempProcess.getProcessTime() - 1);
					if (tempProcess.getProcessTime() == 0) {
						scheduler.priorityQueue0.remove(tempProcess);
						System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses sonlandi (id:"
								+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
								+ tempProcess.getProcessTime() + " sn)\n");
					}
				} 
				//zaten baslamissa calistirmaya devam ediyoruz
				else {

					System.out.println(tempProcess.getColor() + currentTime + " sn proses çalışıyor (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
					tempProcess.setProcessTime(tempProcess.getProcessTime() - 1); // process zamanini azaltiyoruz

					if (tempProcess.getProcessTime() == 0) { // process zamani 0 ise yani bittiyse sonlandiriyoruz
						scheduler.priorityQueue0.remove(tempProcess);
						System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses sonlandi (id:"
								+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
								+ tempProcess.getProcessTime() + " sn)\n");
					}
				}
				tempProcess.setState(1);
			} else if (!scheduler.priorityQueue1.isEmpty()) {
				Process tempProcess = scheduler.priorityQueue1.element();
				tempProcess.setProcessTime(tempProcess.getProcessTime() - 1);
				// tempProcess.setPriority(tempProcess.getPriority()-1);

				System.out.println(tempProcess.getColor() + currentTime + " sn proses çalışıyor (id:"
						+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
						+ tempProcess.getProcessTime() + " sn)\n");
				tempProcess.setTimeOut(false);
				tempProcess.setWaitingTime(0);

				if (tempProcess.getProcessTime() == 0) {
					scheduler.priorityQueue1.remove(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses sonlandi (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
				} else {
					tempProcess.setPriority(tempProcess.getPriority() + 1);
					tempProcess.setTimeOut(true);
					scheduler.priorityQueue1.remove(tempProcess);
					scheduler.priorityQueue2.add(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses askida (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
				}
			} else if (!scheduler.priorityQueue2.isEmpty()) {

				Process tempProcess = scheduler.priorityQueue2.element();
				tempProcess.setProcessTime(tempProcess.getProcessTime() - 1);
				System.out.println(tempProcess.getColor() + currentTime + " sn proses çalışıyor (id:"
						+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
						+ tempProcess.getProcessTime() + " sn)\n");
				tempProcess.setTimeOut(false);
				tempProcess.setWaitingTime(0);

				if (tempProcess.getProcessTime() == 0) {
					scheduler.priorityQueue2.remove(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses sonlandi (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
				} else {
					tempProcess.setPriority(tempProcess.getPriority() + 1);
					tempProcess.setTimeOut(true);
					scheduler.priorityQueue2.remove(tempProcess);
					scheduler.priorityQueue3.add(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses askida (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");

				}
			} else if (!scheduler.priorityQueue3.isEmpty()) {
				Process tempProcess = scheduler.priorityQueue3.element();
				tempProcess.setProcessTime(tempProcess.getProcessTime() - 1);

				System.out.println(tempProcess.getColor() + currentTime + " sn proses çalışıyor (id:"
						+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
						+ tempProcess.getProcessTime() + " sn)\n");
				tempProcess.setTimeOut(false);
				tempProcess.setWaitingTime(0);
				if (tempProcess.getProcessTime() == 0) {
					scheduler.priorityQueue3.remove(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses sonlandi (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
				} else {
					tempProcess.setTimeOut(true);
					scheduler.priorityQueue3.remove(tempProcess);
					scheduler.priorityQueue3.add(tempProcess);
					System.out.println(tempProcess.getColor() + (currentTime + 1) + " sn proses askida (id:"
							+ tempProcess.getId() + " Oncelik:" + tempProcess.getPriority() + " kalan sure:"
							+ tempProcess.getProcessTime() + " sn)\n");
				}
			}
			currentTime++;
			scheduler.timeOut();

		}
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		Dispatcher.currentTime = currentTime;
	}
}
