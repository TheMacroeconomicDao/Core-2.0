package gyber.org.mainCore.managers;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class IPFSManager {



    private File file;

    private IPFS ipfsManager;




    @PostConstruct
    public void initIpfsManager(){
        try {
            this.ipfsManager = new IPFS("127.0.0.1", 5001);
            this.ipfsManager.refs.local();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public IPFSManager(File file){
        this.file = file;
    }


    public String getHashFile(File file){

        if(file == null){
            return "";
        }

        try{


            NamedStreamable.FileWrapper fileWraper = new NamedStreamable.FileWrapper(file);
            return this.ipfsManager.add(fileWraper).get(0).hash.toBase58();


        }catch (Exception e){
            e.printStackTrace();
        }


        return "";

    }





}
