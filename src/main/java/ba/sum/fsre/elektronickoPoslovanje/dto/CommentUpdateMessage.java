package ba.sum.fsre.elektronickoPoslovanje.dto;

import ba.sum.fsre.elektronickoPoslovanje.model.KomentarEntity;



public class CommentUpdateMessage {
    private String messageType;
    private KomentarEntity komentar;

    private Integer id;

    public CommentUpdateMessage(String messageType, Integer id) {
        this.messageType = messageType;
        this.id = id;
    }

    public CommentUpdateMessage(String messageType, KomentarEntity komentar) {
        this.messageType = messageType;
        this.komentar = komentar;
    }

    public String getMessageType() {
        return messageType;
    }

    public KomentarEntity getKomentar() {
        return komentar;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setKomentar(KomentarEntity komentar) {
        this.komentar = komentar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
