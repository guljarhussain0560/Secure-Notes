package com.guljar.notes.services;

import com.guljar.notes.model.AuditLog;
import com.guljar.notes.model.Note;

import java.util.List;

public interface AuditLogService {

    void logNoteCreation(String username, Note note);

    void logNoteDelete(String username, Long noteId);

    void logNoteUpdate(String username, Note note);

    List<AuditLog> getAllAuditLogs();

    List<AuditLog> getAuditLogsForNoteId(Long noteId);

}
