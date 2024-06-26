package com.ssudam.reply.mapper;

import com.ssudam.comment.entity.Comment;
import com.ssudam.member.entity.Member;
import com.ssudam.reply.dto.ReplyDto;
import com.ssudam.reply.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReplyMapper {
    static ReplyMapper create() {
        return Mappers.getMapper(ReplyMapper.class);
}

    default Reply replyPostDtoToReply(ReplyDto.Post requestBody) {
        Member member = new Member();
        Comment comment = new Comment();
        Reply reply = new Reply();

        member.setMemberId(requestBody.getMemberId());
        comment.setCommentId(requestBody.getCommentId());
        reply.addMember(member);
        reply.addComment(comment);
        reply.setReply(requestBody.getReply());
        return reply;
    }

    Reply replyPatchDtoToReply(ReplyDto.Patch requestBody);

    @Mapping(target = "nickname", source = "reply.member.nickname")
    ReplyDto.Response replyToReplyResponse(Reply reply);

}
