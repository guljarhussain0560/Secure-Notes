package com.guljar.notes.services.impl;

import com.guljar.notes.model.AuditLog;
import com.guljar.notes.model.Note;
import com.guljar.notes.repositories.AuditLogRepository;
import com.guljar.notes.services.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;
    

    @Override
    public void logNoteCreation(String username, Note note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("CREATED");
        auditLog.setUsername(username);
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setTimestamp(LocalDateTime.now());

        // Save the audit log to the database
        auditLogRepository.save(auditLog);
        
        
    }

    @Override
    public void logNoteDelete(String username, Long noteId) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("DELETED");
        auditLog.setUsername(username);
        auditLog.setNoteId(noteId);
        auditLog.setTimestamp(LocalDateTime.now());

        // Save the audit log to the database
        auditLogRepository.save(auditLog);

    }

    @Override
    public void logNoteUpdate(String username, Note note) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("UPDATED");
        auditLog.setUsername(username);
        auditLog.setNoteId(note.getId());
        auditLog.setNoteContent(note.getContent());
        auditLog.setTimestamp(LocalDateTime.now());

        // Save the audit log to the database
        auditLogRepository.save(auditLog);

    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    @Override
    public List<AuditLog> getAuditLogsForNoteId(Long noteId) {
        return auditLogRepository.findByNoteId(noteId);
    }


}
