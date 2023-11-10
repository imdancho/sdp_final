interface StudyStrategy {
    void study();
}

class OfflineStudy implements StudyStrategy {
    @Override
    public void study(){
        System.out.println("Offline studies have started");
    }
}

class OnlineStudy implements StudyStrategy {
    @Override
    public void study(){
        System.out.println("Online studies have started");
    }
}
