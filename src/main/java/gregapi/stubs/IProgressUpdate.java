package gregapi.stubs;
// PHASE3: IProgressUpdate stub
@SuppressWarnings("unused")
public interface IProgressUpdate {
    void displaySavingString(String str);
    void resetProgressAndMessage(String str);
    void setLoadingProgress(int progress);
}
